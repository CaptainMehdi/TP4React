import Client from "./Client";

const Clients = ({clients}) =>{

    return  (
        <>
            {clients.map((client) => (
                <Client key={client.id}
                        client={client}/>
            ))}
        </>
    )
}

export default Clients