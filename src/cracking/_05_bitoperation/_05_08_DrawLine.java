package cracking._05_bitoperation;

public class _05_08_DrawLine {
	void drawLine(byte[] screen, int width, int x1, int x2, int y){
		int start_offset = x1 % 8;
		int first_full_byte = x1/8;
		if(start_offset != 0){
			first_full_byte++;
		}
		
		int end_offset = x2%8;
		int last_full_byte = x2 /8;
		if(end_offset != 7){
			last_full_byte --;
		}
		
		for(int b = first_full_byte; b<= last_full_byte; b++){
			screen[(width/8)*y+b] = (byte)0xff;
		}
		byte start_mask = (byte) (0xff >> start_offset);
		byte end_mask = (byte) ~(0xff >> (end_offset +1));
		
		if ((x1 / 8) == (x2/8)){
			byte mask = (byte) (start_mask & end_mask);
			screen[(width/8)*y+(x1/8)] |= mask;
		}else{
			if(start_offset != 0){
				int byte_number = (width / 8) * y + first_full_byte - 1;
				screen[byte_number] |= start_mask;
			}
			if(end_offset != 7){
				int byte_number = (width / 8) * y + last_full_byte +1;
				screen[byte_number] |= end_mask;
			}
		}
	}
}
