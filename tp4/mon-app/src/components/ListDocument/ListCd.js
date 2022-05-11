import React, {useEffect, useState} from "react";

const ListCd = () => {
    const [cds, setCd] = useState([])

    useEffect(() => {
        const getCd = async () => {
            const cdsFromServer = await fetchCd()
            setCd(cdsFromServer)

        }
        getCd()
    }, [])

    const fetchCd = async () => {
        const res = await fetch('http://localhost:2002/todos/getAllCd')
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

export default ListCd