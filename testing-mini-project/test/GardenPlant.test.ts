import { GardenPlant } from '../src/GardenPlant';

describe('GardenPlant Tests', () => {
    let gardenPlant: GardenPlant;

    beforeEach(() => {
        gardenPlant = new GardenPlant(0.5);
    });

    it('should set growthRate in constructor and currentHeight should be 0', () => {
        expect(gardenPlant.growthRate).toBe(0.5);
        expect(gardenPlant.currentHeight).toBe(0);
    });

    it('should increase currentHeight by growthRate when watered', () => {
        gardenPlant.water();
        expect(gardenPlant.currentHeight).toBe(0.5);
    });

    it('should decrease currentHeight by 0.5 when pruned', () => {
        gardenPlant.currentHeight = 10;
        gardenPlant.prune();
        expect(gardenPlant.currentHeight).toBe(9.5);
    });

    it('should not decrease currentHeight when callinf prune on a plant with a height of 1.0', () => {
        gardenPlant.currentHeight = 1.0;
        gardenPlant.prune();
        expect(gardenPlant.currentHeight).toBe(1.0);
    });
});