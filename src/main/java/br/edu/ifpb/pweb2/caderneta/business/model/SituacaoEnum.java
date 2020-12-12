package br.edu.ifpb.pweb2.caderneta.business.model;

public enum SituacaoEnum {
	AP("Aprovado"), 
	RP("Reprovado por nota final"), 
	FN("Está na final"), 
	MT("Matriculado"), 
	RF("Reprovado por faltas");
	
	private final String situacao;
	
	SituacaoEnum(String situacao){
		this.situacao = situacao;
	}

	public String getSituacao() {
		return situacao;
	}
	
	
}
