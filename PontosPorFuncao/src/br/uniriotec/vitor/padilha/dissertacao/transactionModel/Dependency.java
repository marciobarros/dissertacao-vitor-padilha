package br.uniriotec.vitor.padilha.dissertacao.transactionModel;



import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import br.uniriotec.vitor.padilha.dissertacao.ElementValidator;
import br.uniriotec.vitor.padilha.dissertacao.XmlFunctionPointElementWithParent;
import br.uniriotec.vitor.padilha.dissertacao.exception.ElementException;

@XmlType(name="dependency")
public class Dependency extends XmlFunctionPointElementWithParent<Transaction> implements ElementValidator{

	private Transaction transactionDependency;
	
	private String ref;
	
	private Boolean canBeWeak;

	public Transaction getTransactionDependency() {
		return transactionDependency;
	}

	public void setTransactionDependency(Transaction transactionDependency) {
		this.transactionDependency = transactionDependency;
	}

	@XmlAttribute(required=true)
	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	@XmlAttribute(required=false)
	public Boolean getCanBeWeak() {
		return canBeWeak;
	}

	public void setCanBeWeak(Boolean canBeWeak) {
		this.canBeWeak = canBeWeak;
	}

	@Override
	public boolean validate() throws ElementException {
		if(this.getRef()==null || this.getRef().equals(""))
			throw new ElementException("Refer�ncia obrigat�ria",this);
		if(getCanBeWeak()==null)
			this.setCanBeWeak(false);
		if(getParent().getParent().getTransactions()!=null){
			for(Transaction transaction:getParent().getParent().getTransactions()) {
				if(transaction.getName().equals(getRef()))
					 return true;
			}
		}
		throw new ElementException("Elemento:'"+getRef()+"' n�o encontrado", this);
	}
}
