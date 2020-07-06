import React from "react"
import useSticky from "./hooks/useSticky.js"
import Navbar from "./components/Header/Navbar"

function App() {
  const { isSticky, element } = useSticky()
  return (
    <>
      <Navbar sticky={isSticky} />
      <Welcome element={element} />
    </>
  )
}

export default App