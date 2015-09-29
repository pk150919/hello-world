package meiqin520;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;




public class StuService {
    /**
     * 查询stu表中所有的数据
     * @return 
     */
    public static List<Stuenty> getAllByDb(){
        List<Stuenty> list=new ArrayList<Stuenty>();
        try {
        	Dbhelper db=new Dbhelper();
            String sql="select * from stu";
            ResultSet rs= db.Search(sql, null);
            while (rs.next()) {
            	String nianji=rs.getString("nianji");
            	String zhuangye=rs.getString("zhuangye");
            	 String kechengmingcheng=rs.getString("kechengmingcheng");
            	 int zhuangyerenshu=rs.getInt("zhuangyerenshu");
            	 String xianxiuneixing=rs.getString("xianxiuneixing");
            	 int xuefen=rs.getInt("xuefen");
            	 int xueshi=rs.getInt("xueshi");
            	 int shangjixueshi=rs.getInt("shangjixueshi");
            	 int shiyanxueshi=rs.getInt("shiyanxueshi");
            	 String qishizhouqi=rs.getString("qishizhuoqi");
            	 String renkelaoshi=rs.getString("renkelaoshi");
            	 String beizhu=rs.getString("beihu");
                //System.out.println(id+" "+name+" "+sex+ " "+num);
                list.add(new Stuenty(nianji, zhuangye, kechengmingcheng, zhuangyerenshu, xianxiuneixing, xuefen, xueshi,
                		shangjixueshi, shiyanxueshi, qishizhouqi, renkelaoshi, beizhu));
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    
    /**
     * 查询指定目录中电子表格中所有的数据
     * @param file 文件完整路径
     * @return
     */
    public static List<Stuenty> getAllByExcel(String file){
        List<Stuenty> list=new ArrayList<Stuenty>();
        try {
            Workbook rwb=Workbook.getWorkbook(new File(file));
            Sheet rs=rwb.getSheet("Test Shee 1");//或者rwb.getSheet(0)
            int clos=rs.getColumns();//得到所有的列
            int rows=rs.getRows();//得到所有的行
            
            System.out.println(clos+" rows:"+rows);
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //第一个是列数，第二个是行数
                	String nianji=rs.getCell(j++, i).getContents();//默认最左边编号也算一列 所以这里得j++
                	String zhuangye=rs.getCell(j++, i).getContents();
                	 String kechengmingcheng=rs.getCell(j++, i).getContents();
                	 String zhuangyerenshu=rs.getCell(j++, i).getContents();
                	 String xianxiuneixing=rs.getCell(j++, i).getContents();
                	 String xuefen=rs.getCell(j++, i).getContents();
                	 String xueshi=rs.getCell(j++, i).getContents();
                	 String shangjixueshi=rs.getCell(j++, i).getContents();
                	 String shiyanxueshi=rs.getCell(j++, i).getContents();
                	 String qishizhouqi=rs.getCell(j++, i).getContents();
                	 String renkelaoshi=rs.getCell(j++, i).getContents();
                	 String beizhu=rs.getCell(j++, i).getContents();
                    //System.out.println("id:"+id+" name:"+name+" sex:"+sex+" num:"+num);
                    list.add(new Stuenty(nianji, zhuangye, kechengmingcheng, Integer.parseInt(zhuangyerenshu),
                    		xianxiuneixing, Integer.parseInt(xuefen),Integer.parseInt(xueshi), Integer.parseInt(shangjixueshi), 
                    		Integer.parseInt(shiyanxueshi), qishizhouqi, renkelaoshi, beizhu));
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        return list;
        
    }
    
    /**
     * 通过Id判断是否存在
     * @param id
     * @return
     */

    
    
    
}