#银行管理系统
---
##1.程序流程

<ul>
    <li> Home(主界面）</li>
        <ul>
            <li> desposit(存款界面）
            <ul>
                <li> Detposit（开始存款）</li>
            </ul>
            </li>
            <li> Landing(登陆界面）
            <ul>
                <li> Withdrawals（取款界面）
                <ul>
                    <li> Withdrawals（JuniorAcc和CurrentlyAcc界面）</li>
                    <li> Withdrawals2（SaveAcc界面）</li>
                </ul>
                </li>
            </ul>
            </li>
            <li> Bank(银行操作界面）
            <ul>
                <li> suspend（冻结界面）</li>
                <li> clear（清空界面）</li>
            </ul>
            </li>
        </ul>
    
</ul>

##2.程序要求

* 案例研究：简单的银行系统
* 您将需要使用敏捷方法开发一个简单的银行系统，从需求到分析/设计，实施和测试，遵循讲座中概述的指导方针和活动。
* 每周，您将被要求在开发生命周期中进行一个阶段。
* 请记住，没有绝对正确的答案 - 您的解决方案可能是完全适当的。
* 应该指出，确定系统的要求是任何开发项目中最重要和最复杂的阶段之一，如果这是错误的，它不关于系统的设计有多好， 这将是错误的系统！然而，为了简化案例研究，您将从要求的角度开始，已经详细说明了。
* 尽管如此，在实际系统中，您可能想知道这些注释中缺少的更多细节 - 在这种情况下，您可以做出自己的假设或要求讲师/演示者进行澄清。
情景和系统要求要开发一个简单的银行系统，目的是提供一个通用的，可重复使用的系统，从中开发更现实的系统。
* 系统的要求是提供一些不同的账户，
* 每个都向客户提供特定的服务。
* 以下是系统必须支持的所有类型的帐户：
    * 节省帐户
    * 初级账户
    * 经常账户
* 客户加入银行时，需要选择要打开的帐户类型必须以最小的数字表示。
* 客户可以打开多种类型的帐户。
* 系统支持以下核心功能：
    * 开立账户：为了开立账户，客户必须提供以下信息：
            * 名称
            * 地址
            * 出生日期
        * 要打开的帐户类型
        * 只有16岁以下的客户才能开设一个初级账户。
        * 为了确定客户的信用状况，银行将客户的详细信息发送到信用卡，然后进行信用查询。
        * 如果客户有满意的信用记录，则会打开一个新账户。每个帐户都有一个唯一的帐号。
        * 客户还会为此发出单独的个人识别号码（PIN）帐户。
    * 存款基金：如果存款人可以将资金存入账户提供适当的帐号。
        * 当资金存入时，它们将被清算（资金已经全额计入资金，例如现金），
        * 或未清算（资金转移待处理，例如使用支票）。清算的资金将立即记入账户。
    * 清算资金：外部银行清算系统定期清理未清除资金。
        *一旦清算，它们将立即记入账户。
    * 提取资金：客户可以通过提供从账户中提取资金他们的帐号，
        * 一个适当的身份证明（在这种情况下是他们的个人识别号码）以及要撤回的数额。
        * 客户不能超过其限制许可提取资金。
        * 资金来源的账户类型决定了客户的上限。在初级和储蓄账户的情况下，不退出应导致负平衡。
        * 在经常账户的情况下，客户可以提取额外资金，但不超过其透支额度。
        * 要从Saver账户中提款，最短期限（天）必须是任何撤回之前都可以提出。
    * 暂停帐户：在某些情况下，帐户可能会暂停，不再进一步交易可能会发生，直到帐户重新启动。
    * 关闭账户：客户可以选择关闭账户余额已经清算。



##3.有问题反馈
在使用中有任何问题，欢迎反馈给我，可以用以下联系方式跟我交流

* 邮件(wangtianyou#bupt.edu.cn, 把#换成@)
* QQ: 1033291362
* 个人网站: [@CoffeeAcy个人网站](http://coffeeacy.com/)



##4.关于代码（部分）

```javascript 
    private void Regest(String acc,String a, String b, String c, String  d,String e) throws IOException{
    		accountlist.add(acc);
			namelist.add(a);
			agelist.add(b);
			addresslist.add(c);
			typelist.add(d);
			pinlist.add(e);
			int len=namelist.size();
			String accountnum = accountlist.get(len-1);
			String name = namelist.get(len-1);
			String age = agelist.get(len-1);
	        String address = addresslist.get(len-1);
	        String type = typelist.get(len-1);
	        String pin = pinlist.get(len-1);
	    	String account = "0";
	        String inputFile = "id"+accountnum+"*/pin"+pin+"*/"+name+"/"+age+"/"+address+"/"+type+"/"+account;
	        list.add(new Acclist(name, address, age, type, accountnum, pin,account));
			int nn=list.size();
			textArea.setText("成功:"+list.get(nn-1));
			try{    
				FileWriter fw = new FileWriter("Regest.txt",true);
				BufferedWriter writer = new BufferedWriter(fw);
				writer.write(inputFile);
				writer.newLine();
				writer.close();
			}catch(IOException ex){
				ex.printStackTrace();
			}					
		}
```
---
