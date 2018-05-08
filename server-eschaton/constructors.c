#include "eserver.h"

ServerData* createServer(int port, int serverStatus, struct _u_instance instance, char* input, int inputLen, char* output, int outputLen)
{
  ServerData* sv = malloc(sizeof(ServerData));

  sv->port = port;
  sv->serverStatus = serverStatus;
  sv->instance = instance;
  strcpy(sv->input, input);
  sv->inputLen = inputLen;
  strcpy(sv->output, output);
  sv->outputLen = outputLen;

  return sv;
}

JsonData* createJsonData(json_t *root_j, json_t *map_j, Key_t* map_k, json_error_t error_j)
{
  JsonData* jd = malloc(sizeof(JsonData));

  jd->root_j = root_j;
  jd->map_j = map_j;

  jd->map_k = strdup(map_k);

  jd->error_j = error_j;

  return jd;
}

GameObject* createGameObj(ServerData* sv, JsonData* jd)
{
  GameObject* game = malloc(sizeof(GameObject));

  game->sv = sv;
  game->jd = jd;

  return game;
}