package kr.dogfoot.hwplib.object.bodytext.paragraph.text;

import java.io.UnsupportedEncodingException;

/**
 * 문자 컨트롤 Character
 * 
 * @author neolord
 */
public class HWPCharControlChar extends HWPChar {
	/**
	 * 생성자
	 */
	public HWPCharControlChar() {
	}

	/**
	 * 글자의 종류을 반환한다.
	 * 
	 * @return 글자의 타입
	 */
	@Override
	public HWPCharType getType() {
		return HWPCharType.ControlChar;
	}

	public void setCode(String ch) throws UnsupportedEncodingException {
		byte[] b = ch.getBytes("UTF-16LE");

		if (b.length >= 2) {
			setCode((short) (((b[1] & 0xFF) << 8) | (b[0] & 0xFF)));
		} else if (b.length == 1) {
			setCode((short) (b[0] & 0xFF));
		} else {
			setCode((short) 0);
		}
	}
}
