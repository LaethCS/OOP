package fileCreatorsALGOL;

import java.io.IOException;

public class ConcreteCreatorCsvTxt extends ReaderCreatorALGOL
{

	@Override
	public ReaderProductALGOL factoryMethod(String typ) throws IOException 
	{
		// TODO Auto-generated method stub
		if(typ.equalsIgnoreCase("csv"))
		{
			return new ConcreteProductCsv();
			
		}
		else if(typ.equalsIgnoreCase("txt"))
		{
			return new ConcreteProductTxt();
		}
		else
		{
			throw new UnsupportedOperationException("Noch nicht implementiert!");

		}
	}
	
}
