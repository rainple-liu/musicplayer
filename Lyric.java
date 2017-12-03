package model;

public class Lyric implements Comparable<Lyric>{
	private long time = 0;//ʱ��, ��λΪ10ms  
    private String lyric = "";//���  
  
    /* 
     * ��ȡʱ�� 
     */  
    public long getTime() {  
    return time;  
    }  
    /* 
     * ����ʱ�� 
     * time: �����óɵ�ʱ�� 
     */  
  
    public void setTime(int time) {  
    this.time = time;  
    }  
    /* 
     * ����ʱ�� 
     * time: �����óɵ�ʱ���ַ���, ��ʽΪmm:ss.ms 
     */  
  
    public void setTime(String time) {
    	//System.out.println(time);
    String str[] = time.split(":|\\.");  
    this.time = Integer.parseInt(str[0]) * 6000 + Integer.parseInt(str[1]) * 100 +   
        Integer.parseInt(str[2]);  
    }  
    /* 
     * ��ȡ��� 
     */  
  
    public String getLyric() {  
    return lyric;  
    }  
    /* 
     * ���ø�� 
     */  
  
    public void setLyric(String lyric) {  
    this.lyric = lyric;  
    }  
    /* 
     * ��ӡ��� 
     */  
  
    public void printLyric() {  
    System.out.println(time + ": " + lyric);  
    }
    public int compareTo(Lyric l){
    	return ((this.time == l.getTime() )? 0 : ((this.time>l.getTime()) ? 1 : -1));
    }
    public Lyric(String time,String lyric){
    	this.setTime(time);
    	this.setLyric(lyric);
    }

}
