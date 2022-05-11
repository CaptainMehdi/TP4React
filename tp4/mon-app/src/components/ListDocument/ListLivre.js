import React, {useEffect, useState} from "@types/react";

const ListLivre = () =>{
    const [livres, setlivres] = useState([])

    useEffect(() => {
        const getLivres = async () => {
            const livresFromServer = await fetchLivres()
            setlivres(livresFromServer)

        }
        getLivres()
    }, [])

    const fetchLivres = async () => {
        const res = await fetch('http://localhost:2002/todos/getAllLivres')
        const data = await res.json()
        return data
    }
    return(
        <div>
            {livres.map((livre) =>(
                <div className="tableElement" key={livre.id}>
                    <h5>ID: {livre.id}</h5>
                    <h5>Titre: {livre.titre}</h5>
                    <h5>Auteur: {livre.auteur}</h5>
                    <h5>Categorie: {livre.categorie}</h5>
                </div>
            ))}
        </div>
    )
}

export default ListLivre