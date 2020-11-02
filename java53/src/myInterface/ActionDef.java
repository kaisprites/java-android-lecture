package myInterface;

public class ActionDef implements MyAction {

	@Override
	public void click() {
		System.out.println("클릭");
	}

	@Override
	public void doubleClick() {
		System.out.println("더블클릭");
	}

}
