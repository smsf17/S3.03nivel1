package View;

public class UtilitatsSortidaView {
	public void show(String missatge, boolean isError)
	{
		if (!isError)
		{
			System.out.println(missatge);
		}
		else
		{
			System.err.println(missatge);
		}
	}

}
