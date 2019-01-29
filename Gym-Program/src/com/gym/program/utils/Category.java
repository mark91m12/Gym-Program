package com.gym.program.utils;

public interface Category {
	
//	public enum Team{
//		TEAM
//	}
	
	public interface Male extends Category{
		public enum Male_Age implements Male {
			SUB_JUNIOR, JUNIOR, SENIOR, MASTER1, MASTER2, MASTER3, MASTER4
		}

		public enum Male_Weight implements Male {
			// male weights classes
			MINUS_53, MINUS_59, MINUS_66, MINUS_74, MINUS_83, MINUS_93, MINUS_105, MINUS_120, PLUS_120,
		}
	}
	
	public interface Female extends Category{
		public enum Female_Age implements Female  {
			SUB_JUNIOR, JUNIOR, SENIOR, MASTER1, MASTER2, MASTER3, MASTER4
		}

		public enum Female_Weight implements Female  {
			// female weights classes
			MINUS_43, MINUS_47, MINUS_52, MINUS_57, MINUS_63, MINUS_72, MINUS_84, PLUS_84,
		}
	}
}
