
const Client = ({client}) => {
    return (
        <div>
            <h3>{client.nom}</h3>
            <p>{client.prenom}</p>
        </div>
    )
}

export default Client