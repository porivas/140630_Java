package org.thinker.fs.UI;

public class ExitStoreUI extends AbstractUI {

	@Override
	public void doJob() throws Exception {
		System.out.println("��¥ �����Ͻðڽ��ϱ�?");
		String oper = scanner.nextLine();
		
		if(oper.equals("EXIT")){
			System.out.println("�����߽��ϴ�.");
			System.exit(-1);
		}
	}

}



