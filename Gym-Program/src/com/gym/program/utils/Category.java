package com.gym.program.utils;

public interface Category {
	
//	public enum Team{
//		TEAM
//	}
	
	public interface Male extends Category{
		public enum Male_Age implements Male {
			MALE_SUB_JUNIOR{
	            @Override
	            public String toString() {
	                return "Sub-Junior";
	            }
	        }, MALE_JUNIOR{
	            @Override
	            public String toString() {
	                return "Junior";
	            }
	        }, MALE_SENIOR{
	            @Override
	            public String toString() {
	                return "Senior";
	            }
	        }, MALE_MASTER1{
	            @Override
	            public String toString() {
	                return "Master I";
	            }
	        }, MALE_MASTER2{
	            @Override
	            public String toString() {
	                return "Master II";
	            }
	        }, MALE_MASTER3{
	            @Override
	            public String toString() {
	                return "Master III";
	            }
	        }, MALE_MASTER4{
	            @Override
	            public String toString() {
	                return "Master IV";
	            }
	        }
		}

		public enum Male_Weight implements Male {
			// male weights classes
			MINUS_53{
	            @Override
	            public String toString() {
	                return "-53";
	            }
	        }, MINUS_59{
	            @Override
	            public String toString() {
	                return "59 KG";
	            }
	        }, MINUS_66{
	            @Override
	            public String toString() {
	                return "66 KG";
	            }
	        }, MINUS_74{
	            @Override
	            public String toString() {
	                return "74 KG";
	            }
	        }, MINUS_83{
	            @Override
	            public String toString() {
	                return "83 KG";
	            }
	        }, MINUS_93{
	            @Override
	            public String toString() {
	                return "93 KG";
	            }
	        }, MINUS_105{
	            @Override
	            public String toString() {
	                return "105 KG";
	            }
	        }, MINUS_120{
	            @Override
	            public String toString() {
	                return "120 KG";
	            }
	        }, PLUS_120{
	            @Override
	            public String toString() {
	                return "120+ KG";
	            }
	        }
		}
	}
	
	public interface Female extends Category{
		public enum Female_Age implements Female  {
			FEMALE_SUB_JUNIOR{
	            @Override
	            public String toString() {
	                return "Sub-Junior";
	            }
	        }, FEMALE_JUNIOR{
	            @Override
	            public String toString() {
	                return "Junior";
	            }
	        }, FEMALE_SENIOR{
	            @Override
	            public String toString() {
	                return "Senior";
	            }
	        }, FEMALE_MASTER1{
	            @Override
	            public String toString() {
	                return "Master I";
	            }
	        }, FEMALE_MASTER2{
	            @Override
	            public String toString() {
	                return "Master II";
	            }
	        }, FEMALE_MASTER3{
	            @Override
	            public String toString() {
	                return "Master III";
	            }
	        }, FEMALE_MASTER4{
	            @Override
	            public String toString() {
	                return "Master IV";
	            }
	        }
		}

		public enum Female_Weight implements Female  {
			// female weights classes
			MINUS_43{
	            @Override
	            public String toString() {
	                return "43 KG";
	            }
	        }, MINUS_47{
	            @Override
	            public String toString() {
	                return "47 KG";
	            }
	        }, MINUS_52{
	            @Override
	            public String toString() {
	                return "52 KG";
	            }
	        }, MINUS_57{
	            @Override
	            public String toString() {
	                return "57 KG";
	            }
	        }, MINUS_63{
	            @Override
	            public String toString() {
	                return "63 KG";
	            }
	        }, MINUS_72{
	            @Override
	            public String toString() {
	                return "72 KG";
	            }
	        }, MINUS_84{
	            @Override
	            public String toString() {
	                return "84 KG";
	            }
	        }, PLUS_84{
	            @Override
	            public String toString() {
	                return "84+ KG";
	            }
	        }
		}
	}
}
