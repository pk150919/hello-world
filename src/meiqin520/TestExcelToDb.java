package meiqin520;

import java.util.List;




 
public class TestExcelToDb {
    public static void main(String[] args) {
        //�õ���������е�����
        List<Stuenty> listExcel=StuService.getAllByExcel("d://����� 1.xls");
        /*//�õ����ݿ�������е�����
        List<StuEntity> listDb=StuService.getAllByDb();*/
        
        Dbhelper db=new Dbhelper();
        
        for (Stuenty stuEntity : listExcel) {
            
          
                String sql="insert into stu (nianji,,num) values(?,?,?)";
                String[] str=new String[]{stuEntity.getNianji(),stuEntity.getZhuangye(),String.valueOf(stuEntity.getZhuangyerenshu()),stuEntity.getKechenmingchen(),
                		String.valueOf(stuEntity.getXianxiunneixing()),String.valueOf(stuEntity.getXuefen()),
                		String.valueOf(stuEntity.getXueshi()),String.valueOf(stuEntity.getShangjixueshi()),String.valueOf(stuEntity.getShiyanxueshi()),
                		stuEntity.getQishizhouqi(),stuEntity.getRenkelaoshi(),stuEntity.getBeizhu()+""};
                db.AddU(sql, str);
          
        }
    }
}