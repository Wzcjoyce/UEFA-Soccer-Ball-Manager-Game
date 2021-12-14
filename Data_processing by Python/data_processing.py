import csv
import numpy as np
import pandas as pd
from pandas import DataFrame


def main():

    df_read = pd.read_csv('players_21.csv')

    club_name_list = ["Chelsea","Atletico Madrid","Bayern Munchen",
                      "Lokomotiv Moscow","Red Bull Salzburg", "Real Madrid",
                      "Borussia Mionchengladbach", "Shakhtar Donetsk", "Inter Milan",
                      "Manchester City", "Porto", "Olympiacos","Marseille","Liverpool",
                      "Atalanta", "Ajax", "Midtjylland", "Sevilla", "Spartak Moscow",
                      "Rennes","Borussia Dortmund", "Lazio", "Club Brugge","PFC CSKA Moscow",
                      "Juventus", "Barcelona", "Dynamo Kyiv", "Benfica", "Paris Saint-Germain",
                      "RB Leipzig", "Manchester United", "Galatasaray"]

    
    #df = df_read.loc[(df_read['club_name']=='Chelsea')]

    '''
    for i in range(1,len(club_name_list)):
        temp_df = df_read.loc[(df_read['club_name']== club_name_list[i])]
        df = pd.concat([df, temp_df])
    '''

    df_read = df_read[df_read['club_name'].isin(club_name_list)]

    print(df_read)

    df_read.to_csv('processed_player_2021.csv')
        

main()
