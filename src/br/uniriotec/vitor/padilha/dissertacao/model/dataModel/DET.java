package br.uniriotec.vitor.padilha.dissertacao.model.dataModel;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author marcio.barros
 */
public class DET
{
	private @Getter @Setter String name;

	private @Getter @Setter String ref;

	private @Getter @Setter String description;

	private @Getter @Setter boolean primaryKey;

	private @Getter @Setter boolean hasSemanticMeaning;

	private @Getter @Setter String dataModelElement;

	private @Getter @Setter RET retRef;

	private @Getter @Setter boolean flagcanBeDetInTransation;

	private @Getter @Setter boolean implementada;

	public boolean validate() throws Exception
	{
		if (getName() == null || getName().equals(""))
			throw new Exception("Nome obrigat�rio");
		
		if (getRef() != null && !getRef().equals(""))
			if (getRetRef() == null)
				throw new Exception("Elemento: " + getDataModelElement() + "." + getRef() + " n�o encontrado");

		return true;
	}

	public void charge()
	{
//		if (getRef() != null && !getRef().equals(""))
//		{
//			if (getDataModelElement() == null || getDataModelElement().equals(""))
//			{
//				setDataModelElement(getRef());
//			}
//			
//			for (DataModelElement modelElement : getParent().getParent().getParent().getDataModelElements())
//			{
//				if (modelElement.getName() != null && modelElement.getName().equals(getDataModelElement()))
//				{
//					for (RET ret : modelElement.getRecordTypes())
//					{
//						if (ret.getName().equals(getRef()))
//						{
//							setRetRef(ret);
//						}
//					}
//				}
//			}
//		}
	}
}
