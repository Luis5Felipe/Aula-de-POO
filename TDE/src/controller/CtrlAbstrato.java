package controller;

abstract public class CtrlAbstrato {

	private final CtrlAbstrato 	CTRLPAI; 
	
	public CtrlAbstrato(CtrlAbstrato pai) {
		this.CTRLPAI = pai;
	}
	
	public CtrlAbstrato getCtrlpai() {
		return CTRLPAI;
	}

	abstract public void encerrar();
	
	abstract public Object getBemTangivel();	
}
