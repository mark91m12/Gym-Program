package com.gym.program.utils;

public interface TypeOfRanking {
	
	public enum Team_Single implements TypeOfRanking {
			TEAM{
	            @Override
	            public String toString() {
	                return "Squadra";
	            }   
			},SINGLE_MALE{
				 @Override
		         public String toString() {
	                return "Singolo Maschile";
				} 
			}, SINGLE_FEMALE{
				 @Override
		         public String toString() {
	                return "Singolo Femminile";
				} 
			}
	}
	
	public enum Discipline implements TypeOfRanking {
		BENCHPRESS{
            @Override
            public String toString() {
                return "Panca";
            }   
		}, SQUAT{
            @Override
            public String toString() {
                return "Squat";
            }   
		}, DEADLIFT{
            @Override
            public String toString() {
                return "Stacco";
            }   
		}, ABSOLUTE{
			 @Override
	            public String toString() {
	                return "Assoluto";
	            } 
		}
	}
}
