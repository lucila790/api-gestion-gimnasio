import { useEffect, useState } from "react";

import PlanList from "./components/PlanList";
import PlanForm from "./components/PlanForm";

import {
  obtenerPlanes,
  crearPlan,
  eliminarPlan
} from "./services/planService";

function App() {

  const [planes, setPlanes] = useState([]);

  useEffect(() => {
    cargarPlanes();
  }, []);

  const cargarPlanes = async () => {

    const respuesta = await obtenerPlanes();

    setPlanes(respuesta.data);

  };

  const guardarPlan = async (plan) => {

    await crearPlan(plan);

    cargarPlanes();

  };

  const borrarPlan = async (id) => {

    await eliminarPlan(id);

    cargarPlanes();

  };

  return (
    <>

      <h1>Gestión Gimnasio</h1>

      <PlanForm
        onGuardar={guardarPlan}
      />

      <hr />

      <PlanList
        planes={planes}
        onEliminar={borrarPlan}
      />

    </>
  );
}

export default App;