package examen;

import java.util.Objects;

class Vehicle{
    private String matricula;
    private String marca;
    private String model;
    private int any;
    private double preu;

    public Vehicle(String matricula, String marca, String model, int any, double preu) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.any = any;
        this.preu = preu;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.marca);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehicle other = (Vehicle) obj;
        return Objects.equals(this.marca, other.marca);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        this.any = any;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "matricula=" + matricula + ", marca=" + marca + ", model=" + model + ", any=" + any + ", preu=" + preu + '}';
    }

    
}