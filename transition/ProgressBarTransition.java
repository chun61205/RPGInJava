package transition;

import javafx.animation.Transition;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;

import monster.BaseMonster;
import player.NovicePlayer;

public class ProgressBarTransition extends Transition{

    private ProgressBar bar;
    private double maxValue;
    private double newValue;
    private double startValue;
    private double nowValue;

    public ProgressBarTransition(Duration duration, ProgressBar bar, BaseMonster monster) {
        setCycleDuration(duration);
        this.bar = bar;
        this.maxValue = monster.getMaxHP();
    }

    public ProgressBarTransition(Duration duration, ProgressBar bar, NovicePlayer player) {
        setCycleDuration(duration);
        this.bar = bar;
        this.maxValue = player.getMaxHP();
    }

    @Override
    protected void interpolate(double fraction) {
        this.nowValue -= ((this.startValue - this.newValue) * fraction * 0.2);
        if(this.nowValue >= this.newValue)
            this.bar.setProgress(this.nowValue / this.maxValue);
    }

    public void setNewValue (double newValue){
        this.newValue = newValue;
    }

    public void setStartValue (double startValue){
        this.startValue = startValue;
        this.nowValue = startValue;
    }
}