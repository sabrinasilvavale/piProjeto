package jobs;

import models.Carro;
import models.Condutor;
import models.Fiscalizador;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class inicializador extends Job{
	
	@Override
	public void doJob() throws Exception{
		if(Carro.count()==0) {
			
			Carro c1 = new Carro();
			c1.nomeCarro = "Savero";
			c1.anoCarro = "2005";
			c1.placaCarro = "C100";
			c1.save();
			
			Carro c2 = new Carro();
			c2.nomeCarro = "Hillux";
			c2.anoCarro = "2008";
			c2.placaCarro = "C200";
			c2.save();
			
			Carro c3 = new Carro();
			c3.nomeCarro = "Audi";
			c3.anoCarro = "2009";
			c3.placaCarro = "C300";
			c3.save();
			
			Fiscalizador f1 = new Fiscalizador();
			f1.nomeFiscalizador = "root";
			f1.emailFiscalizador = "root@gmail.com";
			f1.login = "root";
			f1.senha = "1234";
			f1.contatoFiscalizador = "(84)994001122";
			f1.save();
			
			Fiscalizador f2 = new Fiscalizador();
			f2.nomeFiscalizador = "Angelino";
			f2.emailFiscalizador = "angelino@gmail.com";
			f2.login = "ange.lino";
			f2.senha = "456";
			f2.contatoFiscalizador = "(84) 99476-8970";
			f2.sim = true;
			f2.save();
		
			Condutor cond1 = new Condutor();
			cond1.nomeCondutor = "Rodrigo";
			cond1.emailCondutor = "rodrigo@gmail.com";
			cond1.login = "ro";
			cond1.senha = "ro123";
			cond1.contatoCondutor = "(84)982569745";
			cond1.save();
			
			Condutor cond2 = new Condutor();
			cond2.nomeCondutor = "Mateus";
			cond2.emailCondutor = "mateus@gmail.com";
			cond2.login = "ma";
			cond2.senha = "ma456";
			cond2.contatoCondutor = "(84)982589747";
			cond2.save();
			
		
		}
	}
	
	
	

}
