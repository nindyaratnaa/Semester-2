package models;

import bases.shape;
import interfaces.*;

public class torus extends shape implements 
    threeDimensional, piRequired, massCalculable, massCoverter, shippingCostCalculator {
    
        private double MajorRadius;
        private double MinorRadius;

        public torus(double MajorRadius, double MinorRadius) {
            this.MajorRadius = MajorRadius;
            this.MinorRadius = MinorRadius;
        }

        @Override
        public double getVolume() {
            return 2 * PI * PI * MajorRadius * MinorRadius * MinorRadius;
        }
    
        @Override
        public double getSurfaceArea() {
            return 4 * PI * PI * MajorRadius * MinorRadius;
        }

        @Override
        public double getMass() {
            return getSurfaceArea() * Thickness * Density;
        }

        @Override
        public double gramToKilogram() {
            return getMass() / Denominator;
        }

        @Override
        public double calculateCost() {
            return Math.ceil(gramToKilogram()) * Price_per_KG;
        }

        @Override
        public void printInfo() {
            System.out.printf("Volume          : %.2f cm^3\n", getVolume());
            System.out.printf("Luas permukaan  : %.2f cm^2\n", getSurfaceArea());
            System.out.printf("Massa           : %.2f gr\n", getMass());
            System.out.printf("Massa dalam kg  : %.2f kg\n", gramToKilogram());
            System.out.printf("Biaya kirim     : Rp %.0f\n", calculateCost());
        }
    }