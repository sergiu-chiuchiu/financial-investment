package com.aib;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("started test");
        KieServices kService=KieServices.Factory.get();
		KieContainer kContainer=kService.getKieClasspathContainer();
		KieSession kSession=kContainer.newKieSession("ksession-rules");
		Product p1=new Product("Ornion", "Medicine", 10.0);
		Product p2=new Product("Milk", "Grocery", 10.0);
		Product p3=new Product("Paracetamol", "Medicine", 20.0);
		Product p4=new Product("Vitamins", "Medicine", 40.0);
		Client c1=new Client("Alfa", "New");
		Client c2=new Client("Beta", "New");
		Order o=new Order(c1, 1, new Date());
		Article a1=new Article(p1, o, 10.0);
		Article a2=new Article(p2, o, 5.0);
		List<Article> list=new ArrayList<Article>();
		list.add(a1);
		list.add(a2);
		o.setArticles(list);		
		kSession.insert(c1);
		//kSession.insert(c2);
		kSession.insert(p1);
		kSession.insert(p2);
		//kSession.insert(p3);
		//kSession.insert(p4);
		kSession.insert(o);
		kSession.insert(a1);
		kSession.insert(a2);
		kSession.fireAllRules();

	}

}
