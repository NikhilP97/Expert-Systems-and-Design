package miniproject;

public class System_main {

	public static void main(String[] args) {
		// creating an empty array month that will store probablity values of different conditions
		double[] days = new double[32];
		int i;
		
		// initializing the days array
		for(i = 0; i< 32; i++)
		{
			days[i] = 0;
		}
		
		// different weight values weight values 
		
		double[] weight = {1, 1.3, 1.5, 1.6, 1.9};
		
//		1.3 -> weight for weekends
//		1.5 -> weight for weather
//		1.6 -> weight for exams 
//		1.9 -> weight for attendance
		
		
		// Probabilities of different conditions
		
		double[] weeknd = {0.06, 0.10};
		// 0.06 -> Probability for a short weekend coming 
		// 0.10 -> Probability for a long weekend coming 
		
		double[] weather = {0.05, 0.08, 0.12};
		// 0.05 -> Probability for ok weather 
		// 0.08 -> Probability for bad weather
		// 0.12 -> Probability for worse weather 
		
		double[] exams = {0.07, 0.14, 0.17};
		// 0.07 -> Probability on exam days 
		// 0.14 -> Probability 2 weeks before exams 
		// 0.17 -> Probability 1 week before exams 
		
		double[] attn = {0.08, 0.13, 0.20};
		// 0.08 -> probability a student has low attendance 
		// 0.13 -> probability a student has mid attendance
		// 0.20 -> probability a student has high attendance
		
		
		// creating list of days 
		
		int[] short_weeknd = {6, 13, 22};// these days short weekends are coming up
		
		int[] long_weeknd = {1, 20}; // these days long weekends are coming up
		
		int[] weather_worse = {1, 24}; // these days worse weathers are coming up
		
		int[] weather_bad = {2, 5, 6, 19, 20, 26, 27, 31}; // these days bad weathers are coming up
		
		int[] weather_ok = {4, 6, 22, 30}; // these days worse ok are coming up
		
		int[] one_week_before = {1, 10, 11, 12,13}; // one week before exam
		
		int[] two_weeks_before = {4, 5, 6}; // 2 weeks before exam 
		
		int[] exam_days = { 16, 17, 18, 19}; // exam days
		
		int[] atten_less = {3, 11, 26}; // less attendance
		
		int[] atten_ok = {2, 5, 10, 20}; // ok attendance
		
		int[] atten_more = {1, 9, 23, 30}; // more attendance
		
		
		
		// mapping
		
		// 1. short weekend 
		//---------------------------------------------------
		
		int length = short_weeknd.length;
		 i = 0;
		int temp;
		while(length != 0)
		{
			temp = short_weeknd[i];
			days[temp] = days[temp] + weeknd[0]*weight[1];
			length--;
			i++;
		}
		
		//----------------------------------------------
		
		
		// 2. long weekend
		//-------------------------------------------------
		
		length = long_weeknd.length;
		i = 0;
		while(length != 0)
		{
			temp = long_weeknd[i];
			days[temp] = days[temp] + weeknd[1]*weight[1];
			length--;
			i++;
		}
		
		//-----------------------------------------------------
		
		
		// 3. weather is ok 
		//------------------------------------------------------
		
		length = weather_ok.length;
		i = 0;
		while(length != 0)
		{
			temp = weather_ok[i];
			days[temp] = days[temp] + weather[0]*weight[2];
			length--;
			i++;
		}
		
		//------------------------------------------------------
		
		
		// 4. weather is bad 
		//-------------------------------------------------------
		
		length = weather_bad.length;
		i = 0;
		while(length != 0)
		{
			temp = weather_bad[i];
			days[temp] = days[temp] + weather[1]*weight[2];
			length--;
			i++;
		}
		
		//---------------------------------------------------------
		
		
		// 5. weather is worse
		//-------------------------------------------------------
		
		length = weather_worse.length;
		i = 0;
		while(length != 0)
		{
			temp = weather_worse[i];
			days[temp] = days[temp] + weather[2]*weight[2];
			length--;
			i++;
		}
		
		//----------------------------------------------------------
		
		
		// 6. 2 weeks before the exam 
		//----------------------------------------------------------
		
		length = two_weeks_before.length;
		i = 0;
		while(length != 0)
		{
			temp = two_weeks_before[i];
			days[temp] = days[temp] + exams[1]*weight[3];
			length--;
			i++;
		}
		
		//-----------------------------------------------------------
		
		
		// 7. 1 week before the exam 
		//-----------------------------------------------------------
		
		length = one_week_before.length;
		i = 0;
		while(length != 0)
		{
			temp = one_week_before[i];
			days[temp] = days[temp] + exams[2]*weight[3];
			length--;
			i++;
		}
		
		//-------------------------------------------------------------
		
		
		// 8. exam days
		
		length = exam_days.length;
		i = 0;
		while(length != 0)
		{
			temp = exam_days[i];
			days[temp] = days[temp] + exams[0]*weight[3];
			length--;
			i++;
		}
		
		//-----------------------------------------------------------------
		
		
		// 9. attendance less
		//------------------------------------------------------------------
		
		length = atten_less.length;
		i = 0;
		while(length != 0)
		{
			temp = atten_less[i];
			days[temp] = days[temp] + attn[0]*weight[4];
			length--;
			i++;
		}
		
		//----------------------------------------------------------------
		
		
		// 10. attendance ok
		//------------------------------------------------------------------
		
		length = atten_ok.length;
		i = 0;
		while(length != 0)
		{
			temp = atten_ok[i];
			days[temp] = days[temp] + attn[1]*weight[4];
			length--;
			i++;
		}
		
		//----------------------------------------------------------------
		
		
		// 11. attendance more
		//------------------------------------------------------------------
		
		length = atten_more.length;
		i = 0;
		while(length != 0)
		{
			temp = atten_more[i];
			days[temp] = days[temp] + attn[2]*weight[4];
			length--;
			i++;
		}
		
		//----------------------------------------------------------------
		
		// for days without any specified condition , probability of bunking is 0.15
		for( i = 1; i< 32; i++)
		{
			if(days[i] == 0)
			{
				days[i] = 0.15;
			}
		}
		
		// after calculating print final probability
		for(i = 1; i< 32; i++)
		{
			System.out.println( "Day "+i+" : "+days[i]);
			if (0.25 > days[i] && days[i] > 0.01)
			{
				System.out.println("Student is LESS likely to bunk");
			}
			else if (0.55 > days[i] && days[i] > 0.25)
			{
				System.out.println("Student is likely to bunk");
			}
			else if (0.75 > days[i] && days[i] > 0.55)
			{
				System.out.println("Student is MORE likely to bunk");
			}
			else if (0.99 > days[i] && days[i] > 0.75)
			{
				System.out.println("Student is MOST likely to bunk");
			}
			System.out.println();
		}


		
		
		
		
		
		
		

	}

}
