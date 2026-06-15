function PlanList({ planes, onEliminar }) {

    return (
        <>
            <h2>Listado de Planes</h2>

            <table border="1">

                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Descripción</th>
                        <th>Precio</th>
                        <th>Duración</th>
                        <th>Sesiones</th>
                        <th>Acciones</th>
                    </tr>
                </thead>

                <tbody>

                    {planes.map(plan => (

                        <tr key={plan.id}>

                            <td>{plan.id}</td>
                            <td>{plan.nombre}</td>
                            <td>{plan.descripcion}</td>
                            <td>${plan.precio}</td>
                            <td>{plan.duracionMeses}</td>
                            <td>{plan.numeroSesionesSemanales}</td>

                            <td>

                                <button
                                    onClick={() => onEliminar(plan.id)}
                                >
                                    Eliminar
                                </button>

                            </td>

                        </tr>

                    ))}

                </tbody>

            </table>
        </>
    );
}

export default PlanList;