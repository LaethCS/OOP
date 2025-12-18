package fileCreatorsALGOL;

import java.io.IOException;

public abstract class ReaderProductALGOL 
{
	public abstract String[] leserAusDatei() throws IOException;
    public abstract void schlieesenDatei() throws IOException;
}
