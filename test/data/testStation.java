package data;


import org.junit.jupiter.api.Test;

class testStation {


    /**
     * 初始化站点信息
     * （每个站点5辆车，占前五个槽位）
     */
    @Test
    void testAddingStation() {
        int i = 1;
        StationList stationList = new StationList();
        Station station1 = new Station(1, 8);
        Station station2 = new Station(2, 8);
        Station station3 = new Station(3, 8);
        for(;i<=5;i++)
            station1.addScooter(new Scooter(i,1));
        for(;i<=10;i++)
            station2.addScooter(new Scooter(i, 0));
        for(;i<=15;i++)
            station3.addScooter(new Scooter(i,0));
        stationList.addStation(station1);
        stationList.addStation(station2);
        stationList.addStation(station3);
    }

    /**
     * 测试是否能读取车的信息
     */
    @Test
    void testGetScooter() {
        StationList stationList = new StationList();
        for (Station station : stationList.getList()) {
            if (station.getId() == 1) {
                if (station.slot[7] == null)
                    System.out.println("no 7");
            }
        }
    }
}
