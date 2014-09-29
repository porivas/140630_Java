package org.han.foodstore.util;

import java.sql.ResultSetMetaData;

public class VOMaker {

	public static void main(String[] args) throws Exception {
		final String query = " select * from tbl_menu where rownum = 1";
		new SqlAgent(){

			@Override
			protected void doJob() throws Exception {
				// TODO Auto-generated method stub
				pstmt = con.prepareStatement(query);
				rs = pstmt.executeQuery();

				ResultSetMetaData meta = rs.getMetaData();
				int colCount = meta.getColumnCount();
				System.out.printf("컬럼수 %d \n", colCount);

				//SQL에선 인덱스 번호가 1부터 시작한다. 
				for (int i = 1; i <= colCount; i++) {
					int type = meta.getColumnType(i);
					//					System.out.println(type);
					String javaType = getType(type);

					//대문자로 결과가 나와서 소문자로 바꿔주었음
					String name = meta.getColumnName(i).toLowerCase();
					//					System.out.println(name);
					System.out.printf("private %s %s;\n", javaType, name);

				}
			}

			private String getType(int type) {
				// TODO Auto-generated method stub
				String result = "String";
				switch(type) {
				case 2:
					result = "Integer";
					break;
				case 93:
					result = "String";
					break;
				default:
					break;

				}

				return result;
			}

		}.doExecute();
	}

}
