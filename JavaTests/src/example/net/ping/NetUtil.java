package example.net.ping;


import java.net.InetAddress;

public class NetUtil {

	/**
	 * Tool for checking if the host is avaliable in default 1s timeout
	 * 
	 * @param hostnameOrIp
	 *            The hostname or the IPAddr
	 * @return
	 */
	public static final boolean isHostAvaliable(String hostnameOrIp) {
		try {
			return InetAddress.getByName(hostnameOrIp).isReachable(1000);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Tool for checking if the host is avaliable in millionTimeout million
	 * seconds
	 * 
	 * @param hostnameOrIp
	 *            The hostname or the IPAddr
	 * @param millionTimeout
	 *            The million seconds of time out
	 * @return
	 */
	public static final boolean isHostAvaliable(String hostnameOrIp,
			int millionSecondsTimeout) {
		try {
			return InetAddress.getByName(hostnameOrIp).isReachable(
					millionSecondsTimeout);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static void main(String[] args){
		System.out.println(NetUtil.isHostAvaliable("127.0.0.1"));
		
	}
}
