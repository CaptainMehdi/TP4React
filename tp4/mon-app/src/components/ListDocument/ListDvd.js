import React, {useEffect, useState} from "react";

const ListDvd = () => {
    const [dvds, setDvd] = useState([])

    useEffect(() => {
        const getDvd = async () => {
            const dvdFromServer = await fetchDvd()
            setDvd(dvdFromServer)

        }
        getDvd()
    }, [])

    const fetchDvd = async () => {
        const res = await fetch('http://localhost:2002/todos/getAllDvd')
        const data = await res.json()
        return data
    }
    return(
        <div>
            {dvds.map((dvd) =>(
                <div className="tableElement" key={dvd.id}>
                    <h5>ID: {dvd.id}</h5>
                    <h5>Titre: {dvd.titre}</h5>
                    <h5>Auteur: {dvd.auteur}</h5>
                    <h5>Categorie: {dvd.categorie}</h5>
                </div>
            ))}
        </div>
    )
}
export default ListDvd