import { useContext } from "react";
import CategorySection from "./components/categories/CategorySection";
import FindingsGrid from "./components/grids/FindingsGrid";
import HomeSearch from "./components/home_search/HomeSearch";
import { AuthContext } from "./context/AuthContext";
import "./App.css";

function App() {
  const { user, token } = useContext(AuthContext);

  return (
    <>
      <HomeSearch
        searchTitle="¡Busca tu experiencia ideal!"
        backgroundImage="https://hips.hearstapps.com/hmg-prod/images/sunset-quotes-21-1586531574.jpg"
      />
      <CategorySection />
      <FindingsGrid />
    </>
  );
}

export default App;
