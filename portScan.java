import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class portScan {
    public static void main(String [] args) {
        // Scanner
        Scanner scanIn = new Scanner(System.in);
        ArrayList<Integer> closedPorts = new ArrayList<Integer>();
        ArrayList<Integer> openPorts = new ArrayList<Integer>();
        ArrayList<Integer> specificPorts = new ArrayList<Integer>();
        int portIn = 0;
        // Host to scan
        System.out.println("Enter Host to Scan:");
        String AddToScan = scanIn.nextLine();

        //Specify Option to (1) Scan all or (2) Strobe
        System.out.println("Would you like either (1) Scan All or (2) Specify ports to scan or (3) Scan most common ports?");
        int option = scanIn.nextInt();
        int[] commonPorts = {1, 5, 7, 9, 11, 13, 17, 18, 19, 20, 21, 22, 23, 25, 37, 39, 42, 43, 49, 50, 53, 63, 67,68, 69, 70, 71, 72, 73, 79, 80, 88, 95, 101, 102, 105, 107, 109, 110, 111, 113, 115, 117, 119, 123, 137, 138, 139, 143, 161, 162, 163, 164, 174, 177, 178, 179, 191, 194, 199, 201, 202, 204, 206, 209, 210, 213, 220, 245, 347, 363, 369, 370, 372, 389, 427, 434, 435, 443, 444, 445, 464, 468, 487, 488, 496, 500, 535, 538, 546, 547, 554, 563, 565, 587, 610, 611, 612, 631, 636, 674, 694, 749, 750, 765, 767, 873, 992, 993, 994, 995};

        if (option == 2) {
            System.out.println("Please enter ports separated by white space and press '-1' when you are done");
            while (portIn != -1){
                portIn = scanIn.nextInt();
                if (portIn != -1) {
                    specificPorts.add(portIn);
                }
            }
        }

        int timeout = 100;
        //Stealth Option
        System.out.println("Would you like to run the scan in stealth mode? (1)Yes (2)No?");
        int stealth = scanIn.nextInt();
        int port = 0;

        // Option 1 - All Ports
        if (option == 1) {
            System.out.println("Running.....");
            for (int x = 1; x <= 65535; x++) {
                try {
                    if (stealth == 1){
                        timeout = (int)(Math.random() * (1000 - 10 + 1) + 10);
                    }
                    else if (stealth == 2) {
                        timeout = 100;
                    }
                    Socket socket = new Socket();
                    socket.connect(new InetSocketAddress(AddToScan, x), timeout);
                    socket.close();
                    openPorts.add(x);
                } catch (Exception ex) {
                    closedPorts.add(x);
                }
            }
            System.out.println("Finished");
            System.out.print("Open Ports: " + openPorts + "\n");
            System.out.println("Closed Ports: " + closedPorts + "\n");
        }

        // Option 2 - Specific Ports
        else if (option == 2) {
            System.out.println("Running.....");
            for (int p = 0; p < specificPorts.size(); p++) {
                try {
                    port = specificPorts.get(p);
                    if (stealth == 1){
                        timeout = (int)(Math.random() * (1000 - 10 + 1) + 10);
                    }
                    else if (stealth == 2) {
                        timeout = 100;
                    }
                    Socket socket = new Socket();
                    socket.connect(new InetSocketAddress(AddToScan, port), timeout);
                    socket.close();
                    openPorts.add(port);
                } catch (Exception ex) {
                    closedPorts.add(port);
                }
            }
            System.out.println("Finished");
            System.out.print("Open Ports: " + openPorts + "\n");
            System.out.println("Closed Ports: " + closedPorts + "\n");
        }

        // Option 3 - Common Ports
        else if (option == 3){
            System.out.println("Running.....");
            for (int i = 0; i < commonPorts.length; i++) {
                try {
                    port = commonPorts[i];
                    if (stealth == 1){
                        timeout = (int)(Math.random() * (1000 - 10 + 1) + 10);
                    }
                    else if (stealth == 2) {
                        timeout = 100;
                    }
                    Socket socket = new Socket();
                    socket.connect(new InetSocketAddress(AddToScan, port), timeout);
                    socket.close();
                    openPorts.add(port);
                } catch (Exception ex) {
                    closedPorts.add(port);
                }
            }
            System.out.println("Finished");
            System.out.print("Open Ports: " + openPorts + "\n");
            System.out.print("Closed Ports: " + closedPorts + "\n");
        }
        else {
            System.out.println("Invalid Option");
        }

        System.out.println("Would you like to Identify the open ports? (1)Yes (2)No");
        int info = scanIn.nextInt();
        if (info == 1) {
            String portDes = "No information available";
            for (int g = 0; g < openPorts.size(); g++) {
                switch(openPorts.get(g)) {
                case 1: portDes = "TCP Port Service Multiplexer (TCPMUX)";
                    break;
                case 2: portDes = "CompressNET Management Utility";
                    break;
                case 3: portDes = "CompressNET Compression Process";
                    break;
                case 5: portDes = "Remote job entry";
                    break;
                case 7: portDes = "Echo Protocol";
                    break;
                case 9: portDes = "Discard Protocol";
                    break;
                case 11: portDes = "Active Users (systat service)";
                    break;
                case 13: portDes = "Daytime Protocol (RFC 867)";
                    break;
                case 17: portDes = "Quote Of The Day";
                    break;
                case 19: portDes = "Character Generator Protocol";
                    break;
                case 20: portDes = "FTP data transfer";
                    break;
                case 21: portDes = "FTP control (command)";
                    break;
                case 22: portDes = "Secure Shell (SSH), secure logins, file transfers (SCP, SFTP)";
                    break;
                case 23: portDes = "Telnet protocol - unencrypted text communications";
                    break;
                case 24: portDes = "Priv-mail, any private mail system";
                    break;
                case 25: portDes = "Simple Mail Transfer Protocol (SMTP)";
                    break;
                case 27: portDes = "NSW User System FE";
                    break;
                case 29: portDes = "MSG ICP";
                    break;
                case 33: portDes = "Display Support Protocol";
                    break;
                case 35: portDes = "Any private printer server protocol";
                    break;
                case 37: portDes = "Time Protocol";
                    break;
                case 39: portDes = "Resource Location Protocol (RLP)";
                    break;
                case 42: portDes = "ARPA Host Name Server Protocol";
                    break;
                case 43: portDes = "WHOIS protocol";
                    break;
                case 47: portDes = "NI FTP";
                    break;
                case 49: portDes = "TACACS+ Login Host protocol";
                    break;
                case 50: portDes = "Remote Mail Checking Protocol";
                    break;
                case 51: portDes = "IMP Logical Address Maintenance";
                    break;
                case 52: portDes = "XNS (Xerox Network Systems) Time Protocol";
                    break;
                case 53: portDes = "Domain Name System (DNS)";
                    break;
                case 54: portDes = "Xerox Network Systems (XNS) clearinghouse";
                    break;
                case 55: portDes = "ISI Graphics Language (ISI-GL)";
                    break;
                case 56: portDes = "Xerox Network Systems (XNS) authentication";
                    break;
                case 57: portDes = "Any private terminal access";
                    break;
                case 58: portDes = "Xerox Network Systems (XNS) Mail";
                    break;
                case 64: portDes = "CI (Travelport) (formerly Covia) Comms Integrator";
                    break;
                case 67: portDes = "Bootstrap Protocol (BOOTP) server or Dynamic Host Configuration Protocol (DHCP)";
                    break;
                case 68: portDes = "Bootstrap Protocol (BOOTP) client or Dynamic Host Configuration Protocol (DHCP)";
                    break;
                case 69: portDes = "Trivial File Transfer Protocol (TFTP)";
                    break;
                case 70: portDes = "Gopher protocol";
                    break;
                case 71: portDes = "NETRJS protocol";
                    break;
                case 72: portDes = "NETRJS protocol";
                    break;
                case 73: portDes = "NETRJS protocol";
                    break;
                case 74: portDes = "NETRJS protocol";
                    break;
                case 77: portDes = "Any private Remote job entry";
                    break;
                case 79: portDes = "Finger protocol";
                    break;
                case 80: portDes = "Hypertext Transfer Protocol (HTTP)";
                    break;
                case 88: portDes = "Kerberos authentication system";
                    break;
                case 90: portDes = "DNSIX Security Attribute Token Map";
                    break;
                case 101: portDes = "NIC host name";
                    break;
                case 102: portDes = "ISO Transport Service Access Point (TSAP)";
                    break;
                case 104: portDes = "ACR/NEMA Digital Imaging and Communications in Medicine (DICOM)";
                    break;
                case 105: portDes = "CCSO Nameserver Protocol (Qi/Ph)";
                    break;
                case 107: portDes = "Remote Telnet Service protocol";
                    break;
                case 108: portDes = "SNA Gateway Access Server";
                    break;
                case 109: portDes = "Post Office Protocol v2 (POP2)";
                    break;
                case 110: portDes = "Post Office Protocol v3 (POP3)";
                    break;
                case 111: portDes = "ONC RPC (Sun RPC)";
                    break;
                case 113: portDes = "Ident, authentication service/identification protocol";
                    break;
                case 115: portDes = "Simple File Transfer Protocol";
                    break;
                case 118: portDes = "Structured Query Language (SQL) Services";
                    break;
                case 119: portDes = "Network News Transfer Protocol (NNTP)";
                    break;
                case 123: portDes = "Network Time Protocol (NTP)";
                    break;
                case 126: portDes = "Formerly Unisys Unitary Login, renamed by Unisys to NXEdit";
                    break;
                case 135: portDes = "DCE endpoint resolution";
                    break;
                case 137: portDes = "NetBIOS Name Service";
                    break;
                case 138: portDes = "NetBIOS Datagram Service";
                    break;
                case 139: portDes = "NetBIOS Session Service";
                    break;
                case 143: portDes = "Internet Message Access Protocol (IMAP)";
                    break;
                case 152: portDes = "Background File Transfer Program (BFTP)";
                    break;
                case 153: portDes = "Simple Gateway Monitoring Protocol (SGMP)";
                    break;
                case 156: portDes = "SQL Service";
                    break;
                case 162: portDes = "Simple Network Management Protocol Trap (SNMPTRAP)";
                    break;
                case 170: portDes = "Print-srv, Network PostScript";
                    break;
                case 175: portDes = "VMNET (IBM z/VM, z/OS & z/VSE—Network Job Entry (NJE))";
                    break;
                case 177: portDes = "X Display Manager Control Protocol (XDMCP)";
                    break;
                case 179: portDes = "Border Gateway Protocol (BGP)";
                    break;
                case 194: portDes = "Internet Relay Chat (IRC)";
                    break;
                case 199: portDes = "SMUX, SNMP Unix Multiplexer";
                    break;
                case 201: portDes = "AppleTalk Routing Maintenance";
                    break;
                case 209: portDes = "Quick Mail Transfer Protocol";
                    break;
                case 210: portDes = "ANSI Z39.50";
                    break;
                case 213: portDes = "Internetwork Packet Exchange (IPX)";
                    break;
                case 218: portDes = "Message posting protocol (MPP)";
                    break;
                case 220: portDes = "Internet Message Access Protocol (IMAP), version 3";
                    break;
                case 259: portDes = "Efficient Short Remote Operations (ESRO)";
                    break;
                case 262: portDes = "Arcisdms";
                    break;
                case 264: portDes = "Border Gateway Multicast Protocol (BGMP)";
                    break;
                case 280: portDes = "http-mgmt";
                    break;
                case 308: portDes = "Novastor Online Backup";
                    break;
                case 311: portDes = "Mac OS X Server Admin";
                    break;
                case 318: portDes = "PKIX Time Stamp Protocol (TSP)";
                    break;
                case 350: portDes = "Mapping of Airline Traffic over Internet Protocol (MATIP) type A";
                    break;
                case 351: portDes = "Mapping of Airline Traffic over Internet Protocol (MATIP) type B";
                    break;
                case 356: portDes = "cloanto-net-1 (used by Cloanto Amiga Explorer and VMs)";
                    break;
                case 366: portDes = "On-Demand Mail Relay (ODMR)";
                    break;
                case 369: portDes = "Rpc2portmap";
                    break;
                case 370: portDes = "codaauth2, Coda authentication server";
                    break;
                case 371: portDes = "ClearCase albd";
                    break;
                case 383: portDes = "HP data alarm manager";
                    break;
                case 384: portDes = "A Remote Network Server System";
                    break;
                case 387: portDes = "AURP (AppleTalk Update-based Routing Protocol)[22]";
                    break;
                case 389: portDes = "Lightweight Directory Access Protocol (LDAP)";
                    break;
                case 399: portDes = "Digital Equipment Corporation DECnet (Phase V+) over TCP/IP";
                    break;
                case 401: portDes = "Uninterruptible power supply (UPS)";
                    break;
                case 427: portDes = "Service Location Protocol (SLP)";
                    break;
                case 433: portDes = "NNSP, part of Network News Transfer Protocol";
                    break;
                case 434: portDes = "Mobile IP Agent (RFC 5944)";
                    break;
                case 443: portDes = "Hypertext Transfer Protocol over TLS/SSL (HTTPS)";
                    break;
                case 444: portDes = "Simple Network Paging Protocol (SNPP), RFC 1568";
                    break;
                case 445: portDes = "Microsoft-DS Active Directory, Windows shares";
                    break;
                case 464: portDes = "Kerberos Change/Set password";
                    break;
                case 465: portDes = "URL Rendezvous Directory for SSM (Cisco protocol)";
                    break;
                case 475: portDes = "tcpnethaspsrv, Aladdin Knowledge Systems Hasp services";
                    break;
                case 497: portDes = "Dantz Retrospect";
                    break;
                case 500: portDes = "Internet Security Association and Key Management Protocol (ISAKMP) / Internet Key Exchange (IKE)";
                    break;
                case 502: portDes = "Modbus Protocol";
                    break;
                case 504: portDes = "Citadel, multiservice protocol for dedicated clients for the Citadel groupware system";
                    break;
                case 510: portDes = "FirstClass Protocol (FCP)";
                    break;
                case 512: portDes = "Rexec, Remote Process Execution";
                    break;
                case 513: portDes = "rlogin";
                    break;
                case 514: portDes = "Remote Shell, used to execute non-interactive commands on a remote system (Remote Shell, rsh, remsh)";
                    break;
                case 515: portDes = "Line Printer Daemon (LPD), print service";
                    break;
                case 520: portDes = "efs, extended file name server";
                    break;
                case 524: portDes = "NetWare Core Protocol (NCP)";
                    break;
                case 530: portDes = "Remote procedure call (RPC)";
                    break;
                case 532: portDes = "netnews";
                    break;
                case 540: portDes = "Unix-to-Unix Copy Protocol (UUCP)";
                    break;
                case 542: portDes = "commerce (Commerce Applications)";
                    break;
                case 543: portDes = "klogin, Kerberos login";
                    break;
                case 544: portDes = "kshell, Kerberos Remote shell";
                    break;
                case 546: portDes = "DHCPv6 client";
                    break;
                case 547: portDes = "DHCPv6 server";
                    break;
                case 548: portDes = "Apple Filing Protocol (AFP) over TCP";
                    break;
                case 550: portDes = "new-rwho, new-who";
                    break;
                case 554: portDes = "Real Time Streaming Protocol (RTSP)";
                    break;
                case 556: portDes = "Remotefs, RFS, rfs_server";
                    break;
                case 563: portDes = "NNTP over TLS/SSL (NNTPS)";
                    break;
                case 587: portDes = "e-mail message submission (SMTP)";
                    break;
                case 591: portDes = "FileMaker 6.0 (and later) Web Sharing (HTTP Alternate)";
                    break;
                case 593: portDes = "HTTP RPC Ep Map";
                    break;
                case 601: portDes = "Reliable Syslog Service";
                    break;
                case 604: portDes = "TUNNEL profile";
                    break;
                case 631: portDes = "Internet Printing Protocol (IPP)";
                    break;
                case 635: portDes = "RLZ DBase";
                    break;
                case 636: portDes = "Lightweight Directory Access Protocol over TLS/SSL (LDAPS)";
                    break;
                case 639: portDes = "MSDP, Multicast Source Discovery Protocol";
                    break;
                case 641: portDes = "SupportSoft Nexus Remote Command (control/listening)";
                    break;
                case 643: portDes = "SANity";
                    break;
                case 646: portDes = "Label Distribution Protocol (LDP)";
                    break;
                case 647: portDes = "DHCP Failover protocol";
                    break;
                case 648: portDes = "Registry Registrar Protocol (RRP)";
                    break;
                case 651: portDes = "IEEE-MMS";
                    break;
                case 653: portDes = "SupportSoft Nexus Remote Command";
                    break;
                case 654: portDes = "Media Management System (MMS) Media Management Protocol (MMP)";
                    break;
                case 657: portDes = "IBM RMC (Remote monitoring and Control) protocol";
                    break;
                case 660: portDes = "Mac OS X Server administration";
                    break;
                case 674: portDes = "Application Configuration Access Protocol (ACAP)";
                    break;
                case 688: portDes = "REALM-RUSD (ApplianceWare Server Appliance Management Protocol)";
                    break;
                case 690: portDes = "Velneo Application Transfer Protocol (VATP)";
                    break;
                case 691: portDes = "MS Exchange Routing";
                    break;
                case 694: portDes = "Linux-HA high-availability heartbeat";
                    break;
                case 695: portDes = "IEEE Media Management System over SSL (IEEE-MMS-SSL)";
                    break;
                case 700: portDes = "Extensible Provisioning Protocol (EPP)";
                    break;
                case 701: portDes = "Link Management Protocol (LMP)";
                    break;
                case 702: portDes = "IRIS (Internet Registry Information Service) over BEEP";
                    break;
                case 706: portDes = "Secure Internet Live Conferencing (SILC)";
                    break;
                case 711: portDes = "Cisco Tag Distribution Protocol";
                    break;
                case 712: portDes = "Topology Broadcast based on Reverse-Path Forwarding routing protocol (TBRPF)";
                    break;
                case 749: portDes = "Kerberos (protocol) administration";
                    break;
                case 753: portDes = "Reverse Routing Header (RRH)";
                    break;
                case 754: portDes = "tell send";
                    break;
                case 800: portDes = "mdbs-daemon";
                    break;
                case 830: portDes = "NETCONF over SSH";
                    break;
                case 831: portDes = "NETCONF over BEEP";
                    break;
                case 832: portDes = "NETCONF for SOAP over HTTPS";
                    break;
                case 833: portDes = "NETCONF for SOAP over BEEP";
                    break;
                case 847: portDes = "DHCP Failover protocol";
                    break;
                case 848: portDes = "Group Domain Of Interpretation (GDOI) protocol";
                    break;
                case 860: portDes = "iSCSI (RFC 3720)";
                    break;
                case 861: portDes = "OWAMP control (RFC 4656)";
                    break;
                case 862: portDes = "TWAMP control (RFC 5357)";
                    break;
                case 873: portDes = "rsync file synchronization protocol";
                    break;
                case 902: portDes = "ideafarm-door (IdeaFarm (tm) Operations)";
                    break;
                case 903: portDes = "ideafarm-panic (IdeaFarm (tm) Operations)";
                    break;
                case 989: portDes = "FTPS Protocol (data), FTP over TLS/SSL";
                    break;
                case 990: portDes = "FTPS Protocol (control), FTP over TLS/SSL";
                    break;
                case 991: portDes = "Netnews Administration System (NAS)";
                    break;
                case 992: portDes = "Telnet protocol over TLS/SSL";
                    break;
                case 993: portDes = "Internet Message Access Protocol over TLS/SSL (IMAPS)";
                    break;
                case 994: portDes = "Internet Relay Chat over TLS/SSL (IRCS)";
                    break;
                case 995: portDes = "Post Office Protocol 3 over TLS/SSL (POP3S)";
                    break;
                case 1025: portDes = "Microsoft RPC";
                    break;
                case 1080: portDes = "SOCKS Proxy";
                    break;
                case 1194: portDes = "OpenVPN";
                    break;
                case 1241: portDes = "Nessus";
                    break;
                case 1311: portDes = "Dell OpenManage";
                    break;
                case 1433: portDes = "Microsoft SQL";
                    break;
                case 1434: portDes = "Microsoft SQL";
                    break;
                case 1512: portDes = "WINS";
                    break;
                case 1589: portDes = "Cisco VQP";
                    break;
                case 1701: portDes = "L2TP";
                    break;
                case 1723: portDes = "MS PPTP";
                    break;
                case 1741: portDes = "CiscoWorks 2000";
                    break;
                case 1812: portDes = "RADIUS";
                    break;
                case 1813: portDes = "RADIUS";
                    break;
                case 1985: portDes = "Cisco HSRP";
                    break;
                case 2000: portDes = "Cisco SCCP";
                    break;
                case 2002: portDes = "Cisco ACS";
                    break;
                case 2049: portDes = "NFS";
                    break;
                case 2082: portDes = "cPanel";
                    break;
                case 2083: portDes = "cPanel";
                    break;
                case 2100: portDes = "Oracle XDB";
                    break;
                case 2222: portDes = "DirectAdmin";
                    break;
                case 2483: portDes = "Oracle DB";
                    break;
                case 2484: portDes = "Oracle DB";
                    break;
                case 3050: portDes = "Interbase DB";
                    break;
                case 3124: portDes = "HTTP Proxy";
                    break;
                case 3128: portDes = "HTTP Proxy";
                    break;
                case 3222: portDes = "GLBP";
                    break;
                case 3260: portDes = "iSCSI Target";
                    break;
                case 3306: portDes = "MySQL";
                    break;
                case 3389: portDes = "Terminal Server";
                    break;
                case 3689: portDes = "iTunes";
                    break;
                case 3690: portDes = "Subversion";
                    break;
                case 4333: portDes = "mSQL";
                    break;
                case 4664: portDes = "Google Desktop";
                    break;
                case 4899: portDes = "Radmin";
                    break;
                case 5000: portDes = "UPnP";
                    break;
                case 5001: portDes = "iperf";
                    break;
                case 5004: portDes = "RTP";
                    break;
                case 5005: portDes = "RTP";
                    break;
                case 5432: portDes = "PostgreSQL";
                    break;
                case 5500: portDes = "VNC Server";
                    break;
                case 5631: portDes = "pcAnywhere";
                    break;
                case 5632: portDes = "pcAnywhere";
                    break;
                case 5800: portDes = "VNC over HTTP";
                    break;
                case 6000: portDes = "X11";
                    break;
                case 6001: portDes = "X11";
                    break;
                case 6129: portDes = "DameWare";
                    break;
                case 6566: portDes = "SANE";
                    break;
                case 6588: portDes = "AnalogX";
                    break;
                case 8080: portDes = "HTTP Proxy";
                    break;
                case 8200: portDes = "VMware Server";
                    break;
                case 8500: portDes = "Adobe ColdFusion";
                    break;
                case 9100: portDes = "HP JetDirect";
                    break;
                case 9101: portDes = "Bacula";
                    break;
                case 9102: portDes = "Bacula";
                    break;
                case 9103: portDes = "Bacula";
                    break;
                case 9800: portDes = "WebDAV";
                    break;
                case 10000: portDes = "Webmin";
                    break;
                case 11371: portDes = "OpenPGP";
                    break;
                case 13720: portDes = "NetBackup";
                    break;
                case 13721: portDes = "NetBackup";
                    break;
                case 19226: portDes = "AdminSecure";
                    break;
                case 19638: portDes = "Ensim";
                    break;
                case 20000: portDes = "Usermin";
                    break;
                case 24800: portDes = "Synergy";
                    break;
                default: portDes = "No description";
                    break;
            }
            System.out.println(openPorts.get(g) + " " + portDes);
            }
            System.out.println("These results are based on most likely services - it is possible that the service ports were manually changed");
        } else {
            System.out.println("Have a nice day!");
        }
    }
}
