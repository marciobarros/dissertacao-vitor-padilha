package br.uniriotec.vitor.padilha.dissertacao.model.dataModel;

import javax.xml.bind.annotation.XmlRootElement;

import br.uniriotec.vitor.padilha.dissertacao.ElementValidator;

@XmlRootElement(name="eif")
public class EIF extends DataModelElement  implements ElementValidator{
	public EIF(){
		setType(DataModelElementType.EIF);
	}

	
}