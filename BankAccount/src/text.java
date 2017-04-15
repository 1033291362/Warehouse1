import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
class reload{
	String name;
	String address;
	String age;
	String type;
	String ID;
	String pin;
	String account;
    public reload(String id, String pin, String name, String age,String address,String type,String account) {
    	this.name=name;
        this.address=address;
        this.age = age;
        this.type = type;
        this.ID=id;
        this.pin = pin;
        this.account = account;
    }  
	@Override
    public String toString() {
        return "\n姓名:"+name+"\n地址:"+address+"\n年龄:"+age+"\n类型:"+type+"\nID:"+ID+"\nPIN:"+pin+"\n总额:"+account;
    }
}

public class text {
	public static void main(String[] args) {
		ArrayList<String> idlist = new ArrayList<String>();
		ArrayList<String> pinlist = new ArrayList<String>();
		ArrayList<String> namelist = new ArrayList<String>();
		ArrayList<String> agelist = new ArrayList<String>();
		ArrayList<String> addresslist = new ArrayList<String>();
		ArrayList<String> typelist = new ArrayList<String>();
		ArrayList<String> accountlist = new ArrayList<String>();
		ArrayList<reload> list = new ArrayList<reload>();
		String tempString = null;
		try {
            File file = new File("Regest.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((tempString = reader.readLine()) != null) {
            	String[] str = tempString.split("/");
            	idlist.add(str[ 0 ]);
            	pinlist.add(str[ 1 ]);
            	namelist.add(str[ 2 ]);
            	agelist.add(str[ 3 ]);
            	addresslist.add(str[ 4 ]);
            	typelist.add(str[ 5 ]);
            	accountlist.add(str[ 6 ]);
            	int len=idlist.size();
            	String id = idlist.get(len-1);
            	String pin = pinlist.get(len-1);
            	String name = namelist.get(len-1);
    			String age = agelist.get(len-1);
    	        String address = addresslist.get(len-1);
    	        String type = typelist.get(len-1);
    	        String acc = accountlist.get(len-1);
            	list.add(new reload(id,pin,name,age,address,type,acc));
    			outString(list);
            }
            reader.close();
        }catch(IOException ex){
			ex.printStackTrace();
		}
	}

	private static void outString(ArrayList<reload> list) {
		// TODO Auto-generated method stub
		int nn=list.size();
		System.out.println(nn);
		System.out.println(list.get(nn-1));
	}
}
