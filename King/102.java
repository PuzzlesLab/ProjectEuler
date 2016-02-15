import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class euler {

	public static double calcTriangleArea (double x1, double y1, double x2, double y2, double x3, double y3) {
		return Math.abs((x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2))/2);
	}
	
	public static void main (String [] args) throws IOException {
		long before=System.currentTimeMillis();
		BufferedReader br=new BufferedReader(new FileReader("D:\\Documents\\King\\Desktop\\p102_triangles.txt"));
		String s;
		int count=0;
		while ((s=br.readLine())!=null) {
			String [] valueStr=s.split(",");
			int [] value=new int [valueStr.length];
			for (int i=0;i<valueStr.length;i++) {
				value[i]=Integer.parseInt(valueStr[i]);
			}
			//calculate the area of triangle.
			//area 1 = p1 - p2 - origin.
			//area 2 = p1 - p3 - origin.
			//area 3 = p2 - p3 - origin.
			//area 1+2+3 should be identical with the area of triangle, otherwise origin is not in the triangle.
			double x1=value[0];
			double y1=value[1];
			double x2=value[2];
			double y2=value[3];
			double x3=value[4];
			double y3=value[5];
			double area=calcTriangleArea(x1,y1,x2,y2,x3,y3);
			double area1=calcTriangleArea(x1,y1,x2,y2,0.0,0.0);
			double area2=calcTriangleArea(x1,y1,0.0,0.0,x3,y3);
			double area3=calcTriangleArea(0.0,0.0,x2,y2,x3,y3);
			if (area1+area2+area3==area) {
				count++;
			}
		}
		br.close();
		System.out.println(count);
		long after=System.currentTimeMillis();
		System.out.println("Took "+(after-before)+" ms.");
	}
	
}