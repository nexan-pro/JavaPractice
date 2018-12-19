package Callback;

public class Functions {
  private IPerform onCallback;

  public void setCallback(IPerform obj) {
    onCallback = obj;
  }

  public void performFunc() {
    if (onCallback != null)
      onCallback.onPerform();
    else
    for(double x = -1; x <= 1; x+=4)
      System.out.println("tan = " + Math.tan(x));
  }
}

class Perform implements IPerform {
  @Override
  public void onPerform() {
    double ctg;
    for(double x = -1; x <= 1; x+=4) {
      ctg = 1.0 / Math.tan(x);
      System.out.println("ctg = " + ctg);
    }
  }
}