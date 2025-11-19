package fileCreatorsALGOL;

import java.io.IOException;

public abstract class ReaderCreatorALGOL 
{
	public abstract ReaderProductALGOL factoryMethod(String typ) throws IOException;
}
