import axios from "axios";

const API_URL = "http://localhost:8080/api/planes";

export const obtenerPlanes = () =>
    axios.get(API_URL);

export const obtenerPlanesEconomicos = (precioMax) =>
    axios.get(`${API_URL}/filtrar?precioMax=${precioMax}`);

export const crearPlan = (plan) =>
    axios.post(API_URL, plan);

export const actualizarPlan = (id, plan) =>
    axios.put(`${API_URL}/${id}`, plan);

export const eliminarPlan = (id) =>
    axios.delete(`${API_URL}/${id}`);