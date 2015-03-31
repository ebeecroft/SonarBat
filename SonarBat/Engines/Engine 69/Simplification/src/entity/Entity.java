package entity;

public class Entity
{
	private Basic basic;	
	protected Entity(){basic = new Basic();}
	Basic getBasic(){return basic;}
}