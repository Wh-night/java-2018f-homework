
public class Calabash
{
	public enum CalabashBrother {
		FIRST("�ϴ�","��ɫ",1),SECOND("�϶�","��ɫ",2),THIRD("����","��ɫ",3),FOURTH("����","��ɫ",4),
		FIFTH("����","��ɫ",5),SIXTH("����","��ɫ",6),SEVENTH("����","��ɫ",7);
		private final String name;
		private final String color;
		private final int rank;
		private CalabashBrother(String name,String color,int rank) {
			this.name=name;
			this.color=color;
			this.rank=rank;
		}
		public String getname() {
			return name;
		}
		public String getcolor() {
			return color;
		}
		public int getrank() {
			return rank;
		}
		public void moveposi(int now,int next) {
			System.out.println(name+":"+now+"->"+next);
		}
	}
	public static void Bubblesort(CalabashBrother[] cbs,int num) {
		for(int i=0;i<num;i++) {
			for(int j=i+1;j<num;j++) {
				if(cbs[i].rank>cbs[j].rank) {
					CalabashBrother tmp=cbs[i];
					cbs[i]=cbs[j];
					cbs[j]=tmp;
					cbs[j].moveposi(i, j);
				}
			}
		}
	}
	public static void binarysort(CalabashBrother[] cbs,int start,int end) {
		for(int i=start+1;i<=end;i++) {
			CalabashBrother tmp=cbs[i];
			int low=0;
			int high=i-1;
			int mid=-1;
			while(low<=high) {
				mid=(high+low)/2;
				if(cbs[mid].getrank()>tmp.getrank()) 
					high=mid-1;
				else
					low=mid+1;
			}
			for(int j=i-1;j>=low;j--) {
				cbs[j+1]=cbs[j];
				cbs[j+1].moveposi(j, j+1);
			}
			cbs[low]=tmp;
			if(i!=low) {
				cbs[low].moveposi(i, low);
			}
		}
	}
	public static void main(String[] args) {
		CalabashBrother[] cbs1= {CalabashBrother.SIXTH,CalabashBrother.THIRD,CalabashBrother.SEVENTH,CalabashBrother.SECOND,CalabashBrother.FIRST,CalabashBrother.FIFTH,CalabashBrother.FOURTH};
		Bubblesort(cbs1,7);
		System.out.println("ð�����������");
		for(int i=0;i<cbs1.length;i++) {
			System.out.println(cbs1[i].getname());
		}
		CalabashBrother[] cbs2= {CalabashBrother.FOURTH,CalabashBrother.THIRD,CalabashBrother.SEVENTH,CalabashBrother.SECOND,CalabashBrother.FIRST,CalabashBrother.SIXTH,CalabashBrother.FIFTH};
		binarysort(cbs2,0,6);
		System.out.println("���ַ����������");
		for(int i=0;i<cbs2.length;i++) {
			System.out.println(cbs2[i].getcolor());
		}
	}
}
