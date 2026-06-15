import { useState } from "react";

function PlanForm({ onGuardar }) {

    const [plan, setPlan] = useState({
        nombre: "",
        descripcion: "",
        precio: "",
        duracionMeses: "",
        numeroSesionesSemanales: ""
    });

    const handleChange = (e) => {
        setPlan({
            ...plan,
            [e.target.name]: e.target.value
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        onGuardar(plan);

        setPlan({
            nombre: "",
            descripcion: "",
            precio: "",
            duracionMeses: "",
            numeroSesionesSemanales: ""
        });
    };

    return (
        <>
            <h2>Nuevo Plan</h2>

            <form onSubmit={handleSubmit}>

                <input
                    type="text"
                    name="nombre"
                    placeholder="Nombre"
                    value={plan.nombre}
                    onChange={handleChange}
                />

                <br /><br />

                <input
                    type="text"
                    name="descripcion"
                    placeholder="Descripción"
                    value={plan.descripcion}
                    onChange={handleChange}
                />

                <br /><br />

                <input
                    type="number"
                    name="precio"
                    placeholder="Precio"
                    value={plan.precio}
                    onChange={handleChange}
                />

                <br /><br />

                <input
                    type="number"
                    name="duracionMeses"
                    placeholder="Duración"
                    value={plan.duracionMeses}
                    onChange={handleChange}
                />

                <br /><br />

                <input
                    type="number"
                    name="numeroSesionesSemanales"
                    placeholder="Sesiones semanales"
                    value={plan.numeroSesionesSemanales}
                    onChange={handleChange}
                />

                <br /><br />

                <button type="submit">
                    Guardar
                </button>

            </form>
        </>
    );
}

export default PlanForm;