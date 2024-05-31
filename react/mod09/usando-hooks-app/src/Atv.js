import React, {useState, useEffect} from "react";

const Atv = () => {
  const[temperatura, setTemperatura] = useState(-5);

  useEffect(() => {
    document.title = `A temperatura atual é de ${temperatura} graus`;
  })

  return(
    <div>
      <p>{`A temperatura atual é de ${temperatura} graus`}</p>
      <button onClick={() => setTemperatura(temperatura + 5)}>
          Click aqui para aumentar a temperatura
      </button>
      <button onClick={() => setTemperatura(temperatura - 5)}>
        Click aqui para diminuir a temperatura
      </button>
    </div>
  )
}

export default Atv;