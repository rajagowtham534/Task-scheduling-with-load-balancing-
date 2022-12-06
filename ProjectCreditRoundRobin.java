package com.creditroundrobin;

import java.util.Scanner;

public class ProjectCreditRoundRobin {

	public static void main(String[] args) {
		    VM1 a=new VM1();
			a.vm();
			
		}
	}
		class 	VM1{
			
			void vm() {
				 int N, temp, tem;
					Scanner s = new Scanner(System.in);
					System.out.println("Enter the Number of VM:");
					int M = s.nextInt();
					int vm[] = new int[M];
					System.out.println("Enter the VM speed:");
					for (int i = 0; i < M; i++) {
						vm[i] = s.nextInt();
					}
					System.out.println("Enter the Number of task:");
					N = s.nextInt();
				int t[] = new int[N];
				System.out.println("Enter the tasks:");
				for (int i = 0; i < N; i++) {
					t[i] = s.nextInt();
				}

				System.out.println("---");
				for (int i = 0; i < N; i++) {
					for (int j = i + 1; j < N; j++) {
						if (t[i] > t[j]) {
							temp = t[i];
							t[i] = t[j];
							t[j] = temp;
						}
					}
				}
				System.out.println("Task in Ascending");
				for (int i = 0; i < N; i++) {
					System.out.println(t[i]);
				}

				for (int i = 0; i < M; i++) {
					for (int j = i + 1; j < M; j++) {
						if (vm[i] < vm[j]) {
							tem = vm[i];
							vm[i] = vm[j];
							vm[j] = tem;
						}
					}
				}
				System.out.println("VM decending");
				for (int i = 0; i < M; i++) {
					System.out.println(vm[i]);
				}
                int total = 0;
				for (int i = 0; i < M; i++) {
					total = total + vm[i];
				}
				System.out.println("Total of VM");
				System.out.println(total);
				double cap[] = new double[M];
				for (int j = 0; j < M; j++) {
					cap[j] = ((double) (vm[j] * 100) / (double) total);
                }
				System.out.println("All Capacities");
                for (int i = 0; i < M; i++) {
					System.out.printf("%.2f", cap[i]);
					System.out.println();
				}

				double CT[][] = new double[N][M];
				double load[] = new double[M];
				int PE = 1;
                for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						CT[i][j] = (double) t[i] / (double) (vm[j] * PE);
					}
				}
				System.out.println();
				System.out.println("Completion Times");
				for (int i = 0; i < N; i++) {
					System.out.println();
					System.out.printf("for task %d", i + 1);
                    for (int j = 0; j < M; j++) {
						System.out.println();
						System.out.printf("%.2f", CT[i][j]);
						load[j] = 0;
					}
				}
                double a[][] = new double[N][M];
				double ts[] = new double[N];
				double tf[] = new double[N];
				System.out.println();
				System.out.println("-loads-");
				for (int i = 0; i < N; i++) {
					for (int j = i % M; j < M; j++) {
						if ((load[j] + CT[i][j]) <= cap[j]) {
							ts[i] = load[j];
							load[j] = load[j] + CT[i][j];
							tf[i] = load[j];
							a[i][j] = 1;
							System.out.println(load[j]);
							break;
						} else
							a[i][j] = 0;
					}
				}
				double makespan = 0;

				for (int j = 0; j < M; j++) {
					if (load[j] > makespan)
						makespan = load[j];
				}
				System.out.println();
				System.out.println("Makespan is");
				System.out.printf("%.2f", makespan);
				System.out.println();
				System.out.println("task start values");
				for (int i = 0; i < N; i++) {
					System.out.println(ts[i]);
				}
				System.out.println("task finish values");
				for (int i = 0; i < N; i++) {
					System.out.println(tf[i]);
				}
				System.out.println("---");
				double RT[] = new double[N];
				for (int i = 0; i < N; i++) {
					if (ts[i] > tf[i])
						RT[i] = ts[i] - tf[i];
					else
						RT[i] = tf[i] - ts[i];
					}
				System.out.println("-Responses times-");
				for (int i = 0; i < N; i++) {
					System.out.println();
					System.out.printf("%.2f", RT[i]);
				}
				double avg_rt, sum = 0;
				for (int i = 0; i < N; i++) {
					sum = sum + RT[i];
              }
				avg_rt = sum / N;
				System.out.println();
				System.out.println("-average response time-");
				System.out.printf("%.2f", avg_rt);
				double t_load = 0;
				for (int j = 0; j < M; j++) {
					t_load = t_load + load[j];
               }
				System.out.println();
				System.out.println("-total load-");
				System.out.println(t_load);
				double ARU = t_load / (makespan * M);
				System.out.println();
				System.out.println("-average resource utilization-");
				System.out.printf("%.2f", ARU);
				double tt[] = new double[N];
				double tl[] = new double[N];
				double at[] = new double[N];
				double wt[] = new double[N];
				double totall=0,lengthavg;
				System.out.println();
				System.out.println("Enter the turnaround times:");
				for (int i = 0; i < N; i++) {
					tt[i] = s.nextInt();
				}
				System.out.println("Enter the taks lengths:");
				for (int i = 0; i < N; i++) {
					tl[i] = s.nextInt();
				}
				for (int i = 0; i < N; i++) {
					totall=totall+tl[i];
				}
				lengthavg=totall/N;
				System.out.println("Average task length:"+lengthavg);
				double high_len,temp1;
				for(int i=0;i<N;i++) {
					for(int j=i+1;j<N;j++) {
						if(tl[i]>tl[j]) {
							temp1=tl[i];
							tl[i]=tl[j];
							tl[j]=temp1;
						}
					}
				}
				high_len=tl[N-1];
				System.out.println("Highest length is "+high_len);
				System.out.println("Enter the Arrival times:");
				for (int i = 0; i < N; i++) {
					at[i] = s.nextInt();
				}
				System.out.println("-waiting Time-");
				for (int i = 0; i < N; i++) {
					if(tt[i]>(tl[i]-at[i])) {
						wt[i] = tt[i] - (tl[i] - at[i]);
					}else
						wt[i] = (tl[i] - at[i])-tt[i];
					System.out.println(wt[i]);
				}
                double awt = 0;
				System.out.println("-Average waiting Time-");
				for (int i = 0; i < N; i++) {
					awt = awt + wt[i];
				}
				awt = awt / N;
				System.out.println(awt);
			double val_1,val_2,val_3,val_4;
			double TLD[]=new double[N];
            double credit[]=new double[N];
			System.out.println("------credits------");
			for(int i=0;i<N;i++) {
			if(lengthavg>tl[i])
			TLD[i]=lengthavg-tl[i];
			else
				TLD[i]=tl[i]-lengthavg;
			val_1=high_len/5;
			val_2=high_len/4;
			val_3=val_2+val_1;
			val_4=val_3+val_2;
			if(TLD[i]<=val_1)
			{
				 credit[i]=5;
			}
			else if(val_1<TLD[i]&&TLD[i]<=val_2)
			{
				credit[i]=4;
			}
			else if(val_2<TLD[i]&&TLD[i]<=val_3)
			{
				 credit[i]=3;
			}
			else if(val_3<TLD[i]&&TLD[i]<=val_4)
			{
				 credit[i]=2;
			}
			else if(val_4<TLD[i])
			{
				 credit[i]=1;
			}
		}
			for (int i = 0; i < N; i++) {

				System.out.println(credit[i]);
			}
			System.out.println("-----TLD'S-----");
			for(int i=0;i<N;i++) {
			System.out.println(TLD[i]);
			}
            System.out.println("Waiting Time before credit");
			for (int i = 0; i < N; i++) {

				System.out.println(wt[i]);
			}
			System.out.println("Waiting Time after adding credit");
			for (int i = 0; i < N; i++) {
            System.out.println(wt[i]+credit[i]);
			}
			
		}
	}


