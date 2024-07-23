import { Plant } from './Plant';

export class GardenPlant implements Plant {
    growthRate: number;
    currentHeight: number = 0;

    constructor(growthRate: number) {
        this.growthRate = growthRate;
    }

    water(): void {
        this.currentHeight += this.growthRate;
    }

    prune(): void {
        if (this.currentHeight > 1.0) {
            this.currentHeight -= 0.5;
        }
    }
}